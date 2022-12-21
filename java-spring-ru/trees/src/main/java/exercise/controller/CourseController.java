package exercise.controller;

import com.fasterxml.jackson.databind.util.ArrayIterator;
import exercise.model.Course;
import exercise.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Locale;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping(path = "")
    public Iterable<Course> getCorses() {
        return courseRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Course getCourse(@PathVariable long id) {
        return courseRepository.findById(id);
    }

    // BEGIN
    @GetMapping(path = "/{id}/previous")
    public Iterable<Course> getParentIdCourseByPath(@PathVariable long id) {
        Course course = courseRepository.findById(id);
        String pathIds = course.getPath();

        if (course.getPath() == null) {
            return new ArrayList<>();
        }

        List<Long> ids = Arrays.stream(pathIds.split("\\."))
                .map(Long::parseLong)
                .toList();

        return courseRepository.findAllById(ids);
    }
    // END

}
