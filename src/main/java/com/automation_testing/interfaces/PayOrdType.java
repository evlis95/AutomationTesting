package com.autotest.interfaces;

import com.autotest.parsingxml.UniversalResponseRootTag;

public interface PayOrdType {


    UniversalResponseRootTag getRootTag();

    String getDocumentID();

    String getDocumentBankID();
}
