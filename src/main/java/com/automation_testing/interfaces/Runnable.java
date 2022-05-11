package com.automation_testing.interfaces;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public interface Runnable {

    void run() throws JAXBException, IOException, InterruptedException;
}
