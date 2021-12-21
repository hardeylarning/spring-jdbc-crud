package demo.jdbc_demo;

import demo.jdbc_demo.dao.DAO;
import demo.jdbc_demo.model.Course;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class JdbcDemoApplication {
    private static DAO<Course> dao;

    public JdbcDemoApplication(DAO<Course> dao) {
        this.dao = dao;
    }

    public static void main(String[] args) {
        SpringApplication.run(JdbcDemoApplication.class, args);

        System.out.println("\n New Course ************************** \n");
        //
        Course course = new Course("PHP Laravel", "Teaching PHP from scratch", "http://localhost/php");
        dao.create(course);
        // get one
        System.out.println("\n Get One Course ************************** \n");
        Optional<Course> firstCourse = dao.get(1);
        System.out.println(firstCourse.get());

        // update
        course.setDescription("Can you imagine the shit was updated");
        dao.update(course, 6);

        //delete
        dao.delete(4);

        // get all
        System.out.println("\n All Courses ************************** \n");
        List<Course> courses = dao.list();
        courses.forEach(System.out::println);
    }
}
