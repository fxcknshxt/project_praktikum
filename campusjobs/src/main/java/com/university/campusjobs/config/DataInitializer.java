package com.university.campusjobs.config;

import com.university.campusjobs.entity.*;
import com.university.campusjobs.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.time.LocalDate;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initData(
            UserRepository userRepository,
            StudentRepository studentRepository,
            EmployerRepository employerRepository,
            CategoryRepository categoryRepository,
            VacancyRepository vacancyRepository) {

        return args -> {
            User studentUser = new User();
            studentUser.setUsername("student1");
            studentUser.setEmail("student1@university.ru");
            studentUser.setPassword("password");
            studentUser.setRole("STUDENT");
            userRepository.save(studentUser);

            Student student = new Student();
            student.setUser(studentUser);
            student.setFullName("Иванов Иван Иванович");
            student.setFaculty("Факультет информационных технологий");
            student.setCourse(3);
            student.setStudentGroup("ИТ-31");
            student.setPhone("+79161234567");
            studentRepository.save(student);
            Category it = new Category();
            it.setName("IT и программирование");
            categoryRepository.save(it);

            Category marketing = new Category();
            marketing.setName("Маркетинг и реклама");
            categoryRepository.save(marketing);

            Category admin = new Category();
            admin.setName("Административная работа");
            categoryRepository.save(admin);

            User employerUser = new User();
            employerUser.setUsername("company1");
            employerUser.setEmail("hr@company.ru");
            employerUser.setPassword("password");
            employerUser.setRole("EMPLOYER");
            userRepository.save(employerUser);

            Employer employer = new Employer();
            employer.setUser(employerUser);
            employer.setCompanyName("ООО Университет Партнёр");
            employer.setDepartment("Отдел стажировок");
            employer.setContactPerson("Анна Иванова");
            employerRepository.save(employer);

            Vacancy v1 = new Vacancy();
            v1.setEmployer(employer);
            v1.setCategory(it);
            v1.setTitle("Junior Java Developer (стажировка)");
            v1.setDescription("Ищем студента на стажировку в разработку backend. Spring Boot, SQL.");
            v1.setSalary(new BigDecimal("45000"));
            v1.setType("INTERNSHIP");
            v1.setLocation("Москва, офис + удалённо");
            v1.setDeadline(LocalDate.now().plusDays(30));
            vacancyRepository.save(v1);

            Vacancy v2 = new Vacancy();
            v2.setEmployer(employer);
            v2.setCategory(marketing);
            v2.setTitle("SMM-менеджер (частичная занятость)");
            v2.setDescription("Ведение соцсетей университета. Создание контента, работа с таргетом.");
            v2.setSalary(new BigDecimal("30000"));
            v2.setType("PART_TIME");
            v2.setLocation("Москва");
            vacancyRepository.save(v2);

            Vacancy v3 = new Vacancy();
            v3.setEmployer(employer);
            v3.setCategory(admin);
            v3.setTitle("Помощник в деканате");
            v3.setDescription("Помощь в административных задачах, работа с документами.");
            v3.setSalary(new BigDecimal("25000"));
            v3.setType("FULL_TIME");
            v3.setLocation("Университетский кампус");
            vacancyRepository.save(v3);

            System.out.println("Тестовые данные успешно загружены! Добавлено " + vacancyRepository.count() + " вакансий.");
        };
    }
}