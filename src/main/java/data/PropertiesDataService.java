package data;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties.Jdbc;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import model.*;

@Repository
public class PropertiesDataService implements PropertiesDataServiceInterface<PropertyModel>
{

    @Autowired
    DataSource dataSource;
    JdbcTemplate jdbcTemplate;

    public PropertiesDataService(DataSource dataSource)
    {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public PropertyModel getById(int id) {
        PropertyModel result = jdbcTemplate.queryForObject("select * from properties where id = ?", new PropertyMapper(), new Object[] {id});
        return result;
    }

    @Override
    public List<PropertyModel> getOrders() {
        return jdbcTemplate.query("select * from properties", new PropertyMapper());
    }

    @Override
    public List<PropertyModel> searchOrders(String searchTerm) {
        return jdbcTemplate.query("select * from properties where name LIKE ?", new PropertyMapper(), new Object[]{"%" + searchTerm + "%"});
    }

    @Override
    public int addOne(PropertyModel newOrder) {
        return jdbcTemplate.update("insert into properties (name, location, squareFeet, dateOfConstruction, photoFileName, description, value) values (?, ?, ?, ?, ?, ?, ?)", newOrder.getNameOfProperty(), newOrder.getLocation(), newOrder.getSquareFeet(), newOrder.getDateOfConstruction(), newOrder.getPhotoFileName(), newOrder.getDescription(), newOrder.getValue());
    }

    @Override
    public boolean deleteOne(long id) {
        int updateResult = jdbcTemplate.update("delete from properties where id = ?", new Object[] {id});
        return (updateResult > 0);
    }

    @Override
    public PropertyModel updateOne(long idToUpdate, PropertyModel updateOrder) {
        int result = jdbcTemplate.update("update properties set name = ?, location = ?, squareFeet = ?, dateOfConstruction = ?, photoFileName = ?, description = ?, value = ? where id = ?", 
        updateOrder.getNameOfProperty(),
        updateOrder.getLocation(),
        updateOrder.getSquareFeet(),
        updateOrder.getDateOfConstruction(),
        updateOrder.getPhotoFileName(),
        updateOrder.getDescription(),
        updateOrder.getValue(),
        idToUpdate );
        if(result > 0)
        {
            return updateOrder;
        }
        else
        {
            return null;
        }
    }
    
}
