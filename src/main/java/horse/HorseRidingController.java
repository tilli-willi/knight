package horse;

import horse.algorythm.HorseRiding;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HorseRidingController {
    @RequestMapping("/horse/rest/count")
    public int greeting(
            @RequestParam(value = "width") int width,
            @RequestParam(value = "height") int height,
            @RequestParam(value = "start") String start,
            @RequestParam(value = "end") String end) {
        return new HorseRiding(width, height, start, end).countDistance();
    }
}
