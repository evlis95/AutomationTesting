package com.automation_testing.interfaces;

import com.automation_testing.parsingxml.UniversalResponseRootTag;

public interface PayOrdType {


    UniversalResponseRootTag getRootTag();

    String getDocumentID();

    String getDocumentBankID();
}
