package drink.roulette.communication;

import drink.roulette.model.Event;

public interface EventListener {

    boolean onEvent(Event event);

}
