package com.hussain.electrician;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class MyController {

    public static final Logger LOGGER = LoggerFactory.getLogger(MyController.class);
    @GetMapping("index")
    public String home(Model model){

        List<ThoughtItems> thoughtItems = getThoughtItems();

        // Add the list of thought items to the model
        LOGGER.info("ThoughtItems: {}", thoughtItems);
        model.addAttribute("thoughtItems", thoughtItems);

        // Create a list of service items
        List<ServiceItems> transportItems = getServiceItems();

        // Add the list of service items to the model
        model.addAttribute("serviceItems", transportItems);

        List<ClientTestimonial> testimonials = getAllTestimonials();
        model.addAttribute("testimonials", testimonials);

        return "index";
    }

    private static List<ThoughtItems> getThoughtItems() {
        List<ThoughtItems> thoughtItems = new ArrayList<>();

        // Add carousel items to the list
        thoughtItems.add(new ThoughtItems("We provide high-quality electrical services.", "At IRAXA TECH SOLUTION, we specialize in a wide range of electrical services, from large-scale commercial installations and data cabling to domestic fuse box repairs. Our commitment to excellence drives us to deliver top-quality solutions for all your electrical needs."));
        thoughtItems.add(new ThoughtItems("Conveniently Located in Hyderabad", "IRAXA TECH SOLUTION is conveniently located in Hyderabad, allowing us to provide timely service to our valued clients across the area. You can count on us to be there when you need us most."));
        thoughtItems.add(new ThoughtItems("Professional and Friendly Team", "Our team at IRAXA TECH SOLUTION consists of fully qualified, friendly, and professional electricians. We pride ourselves on not just completing the job but ensuring it's done right the first time. Your satisfaction is our priority."));
        return thoughtItems;
    }

    @GetMapping("service")
    public String service(Model model){

        // Create a list of transportation items
        List<ServiceItems> transportItems = getServiceItems();

        // Add the list of transportation items to the model
        model.addAttribute("serviceItems", transportItems);

        return "service";
    }

    private static List<ServiceItems> getServiceItems() {

        List<ServiceItems> transportItems = new ArrayList<>();

        transportItems.add(new ServiceItems("Residential Electrical Works", "Providing expert solutions for your home's electrical needs. With our skilled team and dedication to safety, we ensure your electrical systems are reliable and efficient.", "images/residential.jpg"));
        transportItems.add(new ServiceItems("Electrifying Commercial Spaces", "From office complexes to retail stores, we deliver comprehensive electrical solutions, ensuring your business operations run smoothly with safe and efficient electrical systems.", "images/commercial.jpg"));
        transportItems.add(new ServiceItems("Installation Electrical Goods", "Our experienced team ensures precision and efficiency in setting up machinery, helping businesses boost productivity and maintain operational excellence", "images/installation.jpg"));
        transportItems.add(new ServiceItems("Maintenance", "Our dedicated team specializes in keeping your electrical systems and machinery in optimal condition. With regular maintenance services, we ensure reliability, safety, and the longevity of your equipment, allowing your business to operate without disruptions", "images/maintenance.jpg"));

        return transportItems;
    }

    public List<ClientTestimonial> getAllTestimonials() {
        List<ClientTestimonial> testimonials = new ArrayList<>();
        testimonials.add(new ClientTestimonial("Rahbar Alam", "The level of professionalism and commitment IRAXA TECH SOLUTION provides is unmatched. They listen to our needs and consistently deliver on their promises. It's been a pleasure working with a team that cares so deeply.", "images/client-1.png"));
        testimonials.add(new ClientTestimonial("Shadab Hussain", "I highly recommend IRAXA TECH SOLUTION for their outstanding services. Their attention to detail, prompt communication, and innovative solutions have made them a valuable partner in our projects.", "images/client-2.png"));
        testimonials.add(new ClientTestimonial("Anand Kumar", "I'm truly impressed by the dedication and expertise of the team at IRAXA TECH SOLUTION. They've consistently delivered exceptional results for us. Working with them has been a game-changer for our business.", "images/client-1.png"));
        testimonials.add(new ClientTestimonial("Shadab Hussain", "Our experience with IRAXA TECH SOLUTION has been nothing short of exceptional. Their talented team has exceeded our expectations in every project. We look forward to a long-lasting partnership with them.", "images/client-2.png"));

        return testimonials;
    }

    @GetMapping("about")
    public String about(Model model){
        return "about";
    }

    @GetMapping("contact")
    public String contact(Model model){
        return "contact";
    }

}
