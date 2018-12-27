package Database;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import java.util.List;
@Dao
public interface WineWithMeDao {
    //INSERT STATEMENTS FOR TABLES
    @Insert
    public void insertWine(WineEntity wine);
    //WINE QUERIES
    //USED FOR POPULATING RECYCLER AFTER WINE COLOR PAGE
    @Query ("SELECT * FROM wine_table")
    List<WineEntity> getAllWines();
    @Query ("SELECT * FROM wine_table WHERE wine_varietal= :search")
    List<WineEntity> getWineVarietal(String search);
    @Query ("SELECT * FROM wine_table WHERE wine_upc= :search")
    List<WineEntity> getWineName(String search);
}



