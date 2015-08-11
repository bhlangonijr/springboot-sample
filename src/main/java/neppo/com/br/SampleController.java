package neppo.com.br;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SampleController {

    @Autowired
    private HelloWorldService helloWorldService;

    @RequestMapping("/hello")
    @ResponseBody
    public String helloWorld() {
        return this.helloWorldService.getHelloMessage();
    }

}