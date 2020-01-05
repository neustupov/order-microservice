package ru.neustupov.ordermicroservice.proxy;

import io.eventuate.tram.sagas.simpledsl.CommandEndpoint;
import io.eventuate.tram.sagas.simpledsl.CommandEndpointBuilder;
import ru.neustupov.ordermicroservice.channels.AccountingServiceChannels;
import ru.neustupov.ordermicroservice.command.card.Authorize;
import ru.neustupov.ordermicroservice.command.card.Success;

public class AccountingServiceProxy {

  public final CommandEndpoint<Authorize> authorize =
      CommandEndpointBuilder
          .forCommand(Authorize.class)
          .withChannel(AccountingServiceChannels.accountingServiceChannel)
          .withReply(Success.class)
          .build();
}
