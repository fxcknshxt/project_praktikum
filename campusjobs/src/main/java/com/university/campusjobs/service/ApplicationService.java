package com.university.campusjobs.service;

import com.university.campusjobs.entity.Application;
import com.university.campusjobs.entity.CoverLetter;
import com.university.campusjobs.entity.Student;
import com.university.campusjobs.entity.Vacancy;
import com.university.campusjobs.repository.ApplicationRepository;
import com.university.campusjobs.repository.CoverLetterRepository;
import com.university.campusjobs.repository.StudentRepository;
import com.university.campusjobs.repository.VacancyRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ApplicationService {

    private final ApplicationRepository applicationRepository;
    private final StudentRepository studentRepository;
    private final VacancyRepository vacancyRepository;
    private final CoverLetterRepository coverLetterRepository;

    public ApplicationService(ApplicationRepository applicationRepository,
                              StudentRepository studentRepository,
                              VacancyRepository vacancyRepository,
                              CoverLetterRepository coverLetterRepository) {
        this.applicationRepository = applicationRepository;
        this.studentRepository = studentRepository;
        this.vacancyRepository = vacancyRepository;
        this.coverLetterRepository = coverLetterRepository;
    }

    public Application createApplication(Long studentId, Long vacancyId, CoverLetter coverLetter) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Студент не найден"));

        Vacancy vacancy = vacancyRepository.findById(vacancyId)
                .orElseThrow(() -> new RuntimeException("Вакансия не найдена"));

        coverLetter = coverLetterRepository.save(coverLetter);   // ← важно!

        Application application = new Application();
        application.setStudent(student);
        application.setVacancy(vacancy);
        application.setCoverLetter(coverLetter);
        application.setStatus("PENDING");

        return applicationRepository.save(application);
    }

    public List<Application> getStudentApplications(Long studentId) {
        return applicationRepository.findByStudentId(studentId);
    }
}