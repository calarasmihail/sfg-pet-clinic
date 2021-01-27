package guru.springframework.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

  @RequestMapping({"", "/", "index", "index.html"})  // When there's a request that comes in to the
                                                     // empty string, slash, index,
                                                     // or index.html, then they're all going to
                                                     // to match to this RequestMapping.
  public String index() {

    return "index";

  }

  @RequestMapping("/oups")
  public String oupsHandler() {
    return "notimplemented";
  }

}
