package pl.janko.TacoCloud.data;

import pl.janko.TacoCloud.Order;

public interface OrderRepository {
Order save(Order order);
}
