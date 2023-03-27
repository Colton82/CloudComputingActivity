package model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class PropertyMapper implements RowMapper<PropertyModel>
{
        /* match the property names in ORderModel with the column names in the database
     * 
     * Class        Table
     * Properties   Column Names
     * ==========================
     * 
     * id                   id
     * nameOfProperty       name
     * location             location
     * squareFeet           squareFeet
     * dateOfConstruction   dateOfConstruction
     * photoFileName        photoFileName
     * description          description
     * value                value
     */

     public model.PropertyModel mapRow(ResultSet resultSet, int i) throws SQLException 
     {
        PropertyModel property = new PropertyModel(
            resultSet.getInt("id"),
            resultSet.getString("name"),
            resultSet.getString("location"),
            resultSet.getInt("squareFeet"),
            resultSet.getDate("dateOfConstruction"),
            resultSet.getString("photoFileName"),
            resultSet.getString("description"),
            resultSet.getDouble("value")
        );
        return property;
     }
}
