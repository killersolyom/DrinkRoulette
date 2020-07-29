package drink.roulette.communication;

import drink.roulette.model.event.Event;

public interface EventListener {

    boolean onEvent(Event event);

}
