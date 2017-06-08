package org.jabref.logic.sharelatex;

import java.io.IOException;

import org.jabref.JabRefExecutorService;
import org.jabref.logic.importer.ImportFormatPreferences;
import org.jabref.model.database.BibDatabaseContext;

import org.junit.Test;

import static org.mockito.Mockito.mock;

public class SharelatexConnectorTest {

    @Test
    public void test() throws IOException {
        SharelatexConnector connector = new SharelatexConnector();
        connector.connectToServer("http://192.168.1.248", "joe@example.com", "test");
        connector.getProjects();
        //   connector.uploadFile("591188ed98ba55690073c29e",Paths.get("X:\\Users\\CS\\Documents\\_JABREFTEMP\\aaaaaaaaaaaaaa.bib"));
        //   connector.uploadFileWithWebClient("591188ed98ba55690073c29e",
        //         Paths.get("X:\\Users\\CS\\Documents\\_JABREFTEMP\\aaaaaaaaaaaaaa.bib"));

        JabRefExecutorService.INSTANCE.executeAndWait(() -> {

            connector.startWebsocketListener("", new BibDatabaseContext(), mock(ImportFormatPreferences.class));

        });
    }

}
