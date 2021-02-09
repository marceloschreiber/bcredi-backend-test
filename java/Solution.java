import domain.event.Event;
import domain.event.Events;
import domain.proposal.Proposals;
import event.EventParser;
import event.EventProcessorManager;
import event.processors.EventProcessor;
import event.processors.proponent.AddProponent;
import event.processors.proponent.UpdateProponent;
import event.processors.proposal.CreateProposal;
import event.processors.proposal.DeleteProposal;
import event.processors.proposal.UpdateProposal;
import event.processors.warranty.AddWarranty;
import event.processors.warranty.RemoveWarranty;
import validations.AcceptOnlyWarrantiesFromValidProvinces;
import validations.AllProponentsAreInLegalAge;
import validations.AtLeastToProponents;
import validations.HasAtLeastOneWarranty;
import validations.ProposalValidator;
import validations.WarrantiesSumMustDoubleLoanValue;
import validations.hasMainProponent;
import validations.LoanBiggerThanThirtyThousands;
import validations.LoanLowerThanThreeMillions;
import validations.LoanTimeGreaterOrEqualToTwoYears;
import validations.LoanTimeLessOrEqualToFifteenYears;

import java.util.*;

public class Solution {
  // Essa função recebe uma lista de mensagens, por exemplo:
  //
  // [
  //   "72ff1d14-756a-4549-9185-e60e326baf1b,proposal,created,2019-11-11T14:28:01Z,80921e5f-4307-4623-9ddb-5bf826a31dd7,1141424.0,240",
  //   "af745f6d-d5c0-41e9-b04f-ee524befa425,warranty,added,2019-11-11T14:28:01Z,80921e5f-4307-4623-9ddb-5bf826a31dd7,31c1dd83-8fb7-44ff-8cb7-947e604f6293,3245356.0,DF",
  //   "450951ee-a38d-475c-ac21-f22b4566fb29,warranty,added,2019-11-11T14:28:01Z,80921e5f-4307-4623-9ddb-5bf826a31dd7,c8753500-1982-4003-8287-3b46c75d4803,3413113.45,DF",
  //   "66882b68-baa4-47b1-9cc7-7db9c2d8f823,proponent,added,2019-11-11T14:28:01Z,80921e5f-4307-4623-9ddb-5bf826a31dd7,3f52890a-7e9a-4447-a19b-bb5008a09672,Ismael Streich Jr.,42,62615.64,true"
  // ]
  //
  // Complete a função para retornar uma String com os IDs das propostas válidas no seguinte formato (separado por vírgula):
  // "52f0b3f2-f838-4ce2-96ee-9876dd2c0cf6,51a41350-d105-4423-a9cf-5a24ac46ae84,50cedd7f-44fd-4651-a4ec-f55c742e3477"
  public static String processMessages(List<String> messages) {
    List<ProposalValidator> proposalValidators = List.of(
      new LoanBiggerThanThirtyThousands(),
      new LoanLowerThanThreeMillions(),
      new LoanTimeGreaterOrEqualToTwoYears(),
      new LoanTimeLessOrEqualToFifteenYears(),
      new AtLeastToProponents(),
      new hasMainProponent(),
      new AllProponentsAreInLegalAge(),
      new HasAtLeastOneWarranty(),
      new AcceptOnlyWarrantiesFromValidProvinces(),
      new WarrantiesSumMustDoubleLoanValue()
    );

    List<EventProcessor> eventProcessors = List.of(
      new CreateProposal(),
      new UpdateProposal(),
      new DeleteProposal(),
      new AddWarranty(),
      new RemoveWarranty(),
      new AddProponent(),
      new UpdateProponent()
    );

    Proposals proposals = new Proposals(proposalValidators);

    Collection<Event> parsedEvents = EventParser.parseMessagesToEvents(messages);

    Events events = new Events(parsedEvents);
    EventProcessorManager eventProcessor = new EventProcessorManager(proposals, eventProcessors);

    eventProcessor.processEvents(events);

    return proposals.getValidProposals();
  }
}