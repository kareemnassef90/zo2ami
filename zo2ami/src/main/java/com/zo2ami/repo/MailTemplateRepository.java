package com.zo2ami.repo;

import org.springframework.data.repository.CrudRepository;

import com.zo2ami.entity.MailTemplate;

public interface MailTemplateRepository extends CrudRepository<MailTemplate, Long>{

	MailTemplate findByCode(String code);
}
