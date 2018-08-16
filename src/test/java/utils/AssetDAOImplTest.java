package utils;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import model.Asset;

public class AssetDAOImplTest extends AbstractTest {

   private AssetDAOImpl assetDAOImpl;

	@BeforeClass
   public void setUp() throws Exception {
		assetDAOImpl = new AssetDAOImpl(cassandra.session);
   }

	@Test
   public void getAssetsTest() throws Exception {

		//Existing assets in testdb
		Asset asset = new Asset("1", "Window", "Window", "Kaspersky", "0.0.0.0", "1.0.0");

       List<Asset> list = assetDAOImpl.getAssets();

       //assertEquals(list.toString().contains(asset.getType()), true);

       Assert.assertTrue(list.toString().contains(asset.getType()));
   }

	@Test
   public void getAssetsByIdTest() throws Exception {

		//Existing assets in testdb
		Asset asset = new Asset("1", "Window", "Window", "Kaspersky", "0.0.0.0", "1.0.0");

       List<Asset> list = assetDAOImpl.getAssetsById("1");

       //assertEquals(list.toString().contains(asset.getId()), true);

       Assert.assertTrue(list.toString().contains(asset.getId()));
   }

	@Test
   public void getAssetsByTypeTest() throws Exception {

		//Existing assets in testdb
		Asset asset = new Asset("1", "Window", "Window", "Kaspersky", "0.0.0.0", "1.0.0");

       List<Asset> list = assetDAOImpl.getAssetsByType("Window");

       //assertEquals(list.toString().contains(asset.getType()), true);
       Assert.assertTrue(list.toString().contains(asset.getType()));
   }

	@Test
   public void createAssetTest() throws Exception {

		Asset asset = new Asset("0", "test", "test", "test", "0.0.0.0", "1.0.0");

       assetDAOImpl.createAsset(asset);

       //assertEquals(assetDAOImpl.getAssets().contains(asset), true);
       Assert.assertTrue(assetDAOImpl.getAssets().contains(asset));
   }

	@Test
   public void updateAssetTest() throws Exception {

		Asset asset = new Asset("0", "updatedtest", "updatedtest", "updatedtest", "0.0.0.0", "1.0.0");

       assetDAOImpl.updateAsset(asset, "0");

       //assertEquals(assetDAOImpl.getAssets().contains(asset), true);
       Assert.assertTrue(assetDAOImpl.getAssets().contains(asset));
   }

	@Test
   public void deleteAssetTest() throws Exception {

		Asset asset = new Asset("0", "updatedtest", "updatedtest", "updatedtest", "0.0.0.0", "1.0.0");

       assetDAOImpl.deleteAsset(asset.getId());

       //assertEquals(assetDAOImpl.getAssets().contains(asset),false);
       Assert.assertFalse(assetDAOImpl.getAssets().contains(asset));

	}

}