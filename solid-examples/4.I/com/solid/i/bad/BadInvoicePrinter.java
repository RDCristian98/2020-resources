package com.solid.i.bad;

import com.solid.i.ComplexInvoice;
import com.solid.i.Invoice;

public class BadInvoicePrinter implements BadInvoicePrinter_I {

	@Override
	public void print(Invoice invoice) {
		System.out.println("Printing invoice " + invoice);
	}

	@Override
	public void someOtherPrintMethod(Invoice invoice) {
		System.out.println("Printing complex invoice " + invoice);
	}

	@Override
	public void printComplexInvoice(ComplexInvoice complexInvoice) {
		// don't need this here, leaving unimplemented
	}
}
