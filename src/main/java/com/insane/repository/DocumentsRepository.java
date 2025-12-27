package com.insane.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insane.entity.Documents;

public interface DocumentsRepository extends JpaRepository<Documents, Long> {}
