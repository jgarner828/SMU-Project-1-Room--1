package com.room1.demo.service;

import com.room1.demo.models.Invoice;
import com.room1.demo.repositories.InvoiceRepository;
import com.room1.demo.viewmodel.InvoiceViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    @Transactional
    public InvoiceViewModel saveInvoice(InvoiceViewModel viewModel) {
        Invoice i = new Invoice();
        i.setInvoiceId(viewModel.getId());
        i.setName(viewModel.getName());
        i.setStreet(viewModel.getStreet());
        i.setCity(viewModel.getCity());
        i.setState(viewModel.getState());
        i.setItemType(viewModel.getItemType());
        i.setItemId(viewModel.getItemId());
        i.setUnitPrice(viewModel.getUnitPrice());
        i.setQuantity(viewModel.getQuantity());
        i.setSubtotal(viewModel.getSubtotal());
        i.setTax(viewModel.getTax());
        i.setProcessingFee(viewModel.getProcessingFee());
        i.setTotal(viewModel.getTotal());

        invoiceRepository.save(i);
        viewModel.setId(i.getInvoiceId());

        return viewModel;
    }


    public InvoiceViewModel findInvoice(int id)   {
        Optional<Invoice> invoice = invoiceRepository.findById(id);

        return invoice.isPresent() ? buildInvoiceViewModel(invoice.get()) : null;

    }

    public List<InvoiceViewModel> findAllInvoiceViewModels() {
        List<Invoice> invoiceList = invoiceRepository.findAll();
        List<InvoiceViewModel> ivmList = new ArrayList<>();

        for(Invoice invoice : invoiceList) {
            InvoiceViewModel ivm = buildInvoiceViewModel(invoice);
            ivmList.add(ivm);
        }

        return ivmList;
    }
    
    @Transactional
    public void updateInvoice(InvoiceViewModel viewModel) {
        Invoice i = new Invoice();
        i.setInvoiceId(viewModel.getId());
        i.setName(viewModel.getName());
        i.setStreet(viewModel.getStreet());
        i.setCity(viewModel.getCity());
        i.setState(viewModel.getState());
        i.setItemType(viewModel.getItemType());
        i.setItemId(viewModel.getItemId());
        i.setUnitPrice(viewModel.getUnitPrice());
        i.setQuantity(viewModel.getQuantity());
        i.setSubtotal(viewModel.getSubtotal());
        i.setTax(viewModel.getTax());
        i.setProcessingFee(viewModel.getProcessingFee());
        i.setTotal(viewModel.getTotal());
        invoiceRepository.save(i);

    }

    public void removeInvoice(int id) {
        invoiceRepository.deleteById(id);
    }

    private InvoiceViewModel buildInvoiceViewModel(Invoice invoice) {

        InvoiceViewModel ivm = new InvoiceViewModel();
        ivm.setId(invoice.getInvoiceId());
        ivm.setName(invoice.getName());
        ivm.setStreet(invoice.getStreet());
        ivm.setCity(invoice.getCity());
        ivm.setState(invoice.getState());
        ivm.setItemType(invoice.getItemType());
        ivm.setItemId(invoice.getItemId());
        ivm.setUnitPrice(invoice.getUnitPrice());
        ivm.setQuantity(invoice.getQuantity());
        ivm.setSubtotal(invoice.getSubtotal());
        ivm.setTax(invoice.getTax());
        ivm.setProcessingFee(invoice.getProcessingFee());
        ivm.setTotal(invoice.getTotal());

        // Return the Invoice View Model
        return ivm;

    }


}
