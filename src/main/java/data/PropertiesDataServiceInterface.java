package data;

import java.util.List;

public interface PropertiesDataServiceInterface<PropertyModel> {
    public PropertyModel getById(int id);
    public List<PropertyModel> getOrders();
    public List<PropertyModel> searchOrders(String searchTerm);
    public int addOne(PropertyModel newOrder);
    public boolean deleteOne(long id);
    public PropertyModel updateOne(long idToUpdate, PropertyModel updateOrder);
}
