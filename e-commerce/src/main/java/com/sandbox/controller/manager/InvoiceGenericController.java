package com.sandbox.controller.manager;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sandbox.controller.abstraction.WithOneForeignKeyController;
import com.sandbox.dto.manager.InvoiceDTO;
import com.sandbox.entity.manager.Invoice;

@RestController
@RequestMapping(path = "/managerAPI/invoices")
public class InvoiceGenericController extends WithOneForeignKeyController<InvoiceDTO,Invoice> {

}