package ru.hh.school;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ru.hh.school.entity.Resume;
import ru.hh.school.entity.Area;
import ru.hh.school.entity.Employer;
import ru.hh.school.entity.Vacancy;
import java.util.List;

public class DbFactory {

  private static final List<Class<?>> ENTITY_CLASSES_REGISTRY = List.of(
    Employer.class,
    Vacancy.class,
    Resume.class,
    Area.class
  );

  public static SessionFactory createSessionFactory() {
    StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
      .loadProperties("hibernate.properties")
      .build();

    MetadataSources metadataSources = new MetadataSources(serviceRegistry);
    ENTITY_CLASSES_REGISTRY.forEach(metadataSources::addAnnotatedClass);

    return metadataSources.buildMetadata().buildSessionFactory();
  }

}
