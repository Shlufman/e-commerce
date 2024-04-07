package com.sandbox.repository.manager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sandbox.entity.customer.Product;
import com.sandbox.entity.manager.Invoice;
import com.sandbox.repository.abstraction.IUniversalRepo;

@Repository(value = "invoice")
public interface IInvoicesRepo extends JpaRepository<Invoice, String>{ //ICommonRepository<Invoice>

}
