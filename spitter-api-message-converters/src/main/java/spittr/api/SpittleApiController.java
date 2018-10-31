package spittr.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import spittr.Spittle;
import spittr.data.SpittleNotFoundException;
import spittr.data.SpittleRepository;

import java.net.URI;
import java.util.List;

/*
 * @RequestMapping 中的 produces 属性，匹配请求中的 Accept 头
 * consumes 匹配 Content-Type 头
 */

@RestController
@RequestMapping("/spittles")
public class SpittleApiController {

    private static final String MAX_LONG_AS_STRING = "9223372036854775807";

    @Autowired
    private SpittleRepository spittleRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Spittle> spittles(
            @RequestParam(value = "max", defaultValue = MAX_LONG_AS_STRING) long max,
            @RequestParam(value = "count", defaultValue = "20") int count) {
        return spittleRepository.findSpittles(max, count);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Spittle> saveSpittle(@RequestBody Spittle spittle, UriComponentsBuilder ucb) {
        Spittle saved = spittleRepository.save(spittle);
//
//        HttpHeaders headers = new HttpHeaders();
//        URI locationUri = URI.create("http://localhost:8080/spittr/spittles/" + saved.getId());
//        headers.setLocation(locationUri);
//
//        return new ResponseEntity<>(spittle, headers, HttpStatus.CREATED);

        HttpHeaders headers = new HttpHeaders();
        URI locationUri = ucb.path("/spittles/")
                .path(String.valueOf(saved.getId()))
                .build()
                .toUri();
        headers.setLocation(locationUri);

        return new ResponseEntity<>(spittle, headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Spittle spittleById(@PathVariable Long id) {
        return spittleRepository.findOne(id);
    }

    @ExceptionHandler(SpittleNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Error spittleNotFound(SpittleNotFoundException e) {
        long spittleId = e.getSpittleId();
        return new Error(4, "Spittle [" + spittleId + "] not found");
    }
}
