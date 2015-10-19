package nl.ead.dateplanner.services.orchestration;

import nl.ead.dateplanner.services.DatePlannerRequest;
import nl.ead.dateplanner.services.DatePlannerResponse;
import nl.ead.dateplanner.services.PlaceType;
import nl.ead.dateplanner.services.business.DateTaskFactory;
import nl.ead.dateplanner.services.business.IDateTaskService;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.converter.jaxb.JaxbDataFormat;


public class DatePlannerCamelRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        JaxbDataFormat jaxbMatchResponse = new JaxbDataFormat(DatePlannerResponse.class.getPackage().getName());

        from("spring-ws:rootqname:{http://www.han.nl/schemas/dateplanner/}dateplanner?endpointMapping=#dateplannerEndpointMapping")
        .unmarshal(jaxbMatchResponse)
        .process(new Echo())
        .marshal(jaxbMatchResponse); // serialize the java-object from the aggregrator to SOAP/XML
    }

    private static final class Echo implements Processor {

        @Override
        public void process(Exchange exchange) throws Exception {
            //DatePlannerRequest request = exchange.getIn().getBody(DatePlannerRequest.class);

            // TODO Dependency injection
            //IDateTaskService task = new DateTaskFactory().create();
           //exchange.getOut().setBody(task.getDateOption(request.getInput()));

            nl.ead.dateplanner.services.DatePlannerResponse dummy = new nl.ead.dateplanner.services.DatePlannerResponse();
            dummy.getPlaces().add(new PlaceType());

            exchange.getOut().setBody(dummy);
        }
    }
}
