import com.apress.isf.spring.ch03.SearchEngineService
import com.apress.isf.spring.ch03.DocumentRepository
import com.apress.isf.spring.ch02.Document

beans {

    engine(SearchEngineService){ bean ->
        bean.scope = "prototype"
        documentDAO = ref("documentDAO")
    }

    documentDAO(DocumentRepository){ bean ->
        bean.scope = "prototype"
        doc1 = ref("doc1")
        doc2 = ref("doc2")
        doc3 = ref("doc3")
        doc4 = ref("doc4")
    }

    doc1(Document){
        name = "Book Template"
        type = ref("pdfType")
        location = "/Users/felipeg/Documents/Random/Book Template.pdf"
    }

    doc2(Document){
        name = "Sample Contract"
        type = ref("pdfType")
        location = "/Users/felipeg/Documents/Contracts/Sample Contract.pdf"
    }

    doc3(Document){
        name = "Clustering with RabbitMQ"
        type = ref("noteType")
        location = "/Users/felipeg/Documents/Random/Clustering with RabbitMQ.txt"
    }

    doc4(Document){
        name = "Pro Spring Security Book"
        type = ref("webType")
        location = "htttp://www.apress.com.9781430248187"
    }

    webType(com.apress.isf.spring.ch02.Type){
        name = "WEB"
        desc = "Web Link"
        extension = ".url"
    }

    pdfType(com.apress.isf.spring.ch02.Type){
        name = "PDF"
        desc = "Portable Document Format"
        extension = ".pdf"
    }

    noteType(com.apress.isf.spring.ch02.Type){
        name = "NOTE"
        desc = "Text Notes"
        extension = ".txt"
    }
}