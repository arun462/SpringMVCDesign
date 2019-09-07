package com.in.AllCntrls;

import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.BeanFactoryAnnotationUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.in.model.User;
import com.in.model.UserDto;
import com.in.model.UserMailDTO;
import com.in.model.UserOtpDTO;
import com.in.service.UserOTPService;
import com.in.service.UserService;
import com.in.utility.ApplicationConstants;
import com.in.utility.MailandSMSUitility;

@Controller
public class MvcController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	MailandSMSUitility mailandSMSUitility;
	@Autowired
	UserOTPService userOTPService;
	
	
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String Home(Model model){
		
		System.out.println("i am home method");
		model.addAttribute("myValue", "wlcome to registration page");
		UserDto userDto=new UserDto();
		model.addAttribute("userDto", userDto);
		
		return"Registration";
	}
	
	
	@RequestMapping(value="/signup",method=RequestMethod.POST)
	public String signUp(Model model,@ModelAttribute UserDto userDto,HttpSession session){
		User user= new User();
		BeanUtils.copyProperties(userDto, user);
		
		String OTP=userOTPService.GenerateOTP();
		user.setOtp(OTP);
		user.setActiveStatus(0);
		Long tm=System.currentTimeMillis();
	
		
		user.setActivationSession(tm.toString());
		userService.Signup(user);
		mailandSMSUitility.sendMailandSMS(user,ApplicationConstants.OTP_Notification_ID,OTP);
		
		UserOtpDTO userOtpDTO= new UserOtpDTO();
		model.addAttribute( "userOtpDTO",userOtpDTO);
		session.setAttribute("currentTempSession",tm.toString());
		return "otp";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(Model model){
		UserDto userDto=new UserDto();
		model.addAttribute("userDto", userDto);
		
		return"login";
		}

	
	@RequestMapping(value="loginAction",method=RequestMethod.POST)
	public String login(Model model,UserDto userDto,HttpServletRequest request){
		
		User user = new User();
		BeanUtils.copyProperties(userDto, user);
		
			
		/*if( user.getFirstname()!=null && user.getFirstname().equals("xyz")){
			
			//do something...
		} */
		
		User isValidUser=userService.validateUser(user);
		if(isValidUser==null){
			model.addAttribute("myValue3", "invalid credentials");
			
			return "Registration";

		              		}
		else{
			model.addAttribute("myvalue2",user.getUsername());
			HttpSession session=request.getSession();
			session.setAttribute("username", user.getUsername());
			return "Sucess";
			
		}
	}
	
	

	@RequestMapping(value="profile",method=RequestMethod.GET)
	public String getProfile(Model model,HttpSession session){
		String key= (String) session.getAttribute("username");
		System.out.println("executing profile");
		List<User> user=userService.getProfile(key);
		System.out.println(user);
		UserDto userDto=new UserDto();
		
		BeanUtils.copyProperties(user.get(0), userDto);
		System.out.println("the op" + userDto);
		String username=(String) session.getAttribute("username");
		if(username!=null){
			model.addAttribute("UserDto", userDto);
			return"Profile";
			
		}
		else{return "registration";}
		
	}
	
	
	@RequestMapping(value="/usermail",method=RequestMethod.GET)
	public String userEmail(Model model){
		UserMailDTO userMailDTO=new UserMailDTO();
		model.addAttribute("userMailDTO", userMailDTO);
		
		return"usermail";
		}
	
	@RequestMapping(value="/usermail",method=RequestMethod.POST)
	public String reVerificationOtp(@ModelAttribute UserMailDTO userMailDTO,HttpSession session){
		
		String email=userMailDTO.getUseremail();
		User user=new User();
		BeanUtils.copyProperties(userMailDTO, user);		
		String dbUsermail=userService.reVerifictaionMail(user);
		if(email.equals(dbUsermail)){
			System.out.println("this controller is executing");
			return"otpvfbymail";
		                     }
		return "registration";
				
	}
		@RequestMapping(value="/otp",method=RequestMethod.GET)
	public String verifyOTP(Model model){
		UserOtpDTO userOtpDTO=new UserOtpDTO();
		model.addAttribute("userOtpDTO", userOtpDTO);		
		return "otp";
		
	}

	
	@RequestMapping(value="/opt",method=RequestMethod.POST)
	public String VerifyOTP(@ModelAttribute UserOtpDTO userOtpDTO,HttpSession session){
		@SuppressWarnings("unused")
		String userTempSession=(String)session.getAttribute("currentTempSession");
		if(userTempSession!=null){
		User user=new User();
		BeanUtils.copyProperties(userOtpDTO, user);
	    String currentSession=userService.validatingOTP(user);
		if(userTempSession.equals(currentSession)){
		System.out.println(currentSession);
		return "login";
		                    }
		}
		
		return "registration";
		
	}
	
	@RequestMapping(value="/mailOtp",method=RequestMethod.GET)
	@ModelAttribute("userOtpDto")
	public String verifymailOTP(Model model){
		UserOtpDTO userOtpDTO=new UserOtpDTO();
		model.addAttribute("userOtpDTO", userOtpDTO);		
		return "otpvfbymail";
		
	}
}
