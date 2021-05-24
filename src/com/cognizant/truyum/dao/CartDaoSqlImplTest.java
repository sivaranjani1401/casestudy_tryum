package com.cognizant.truyum.dao;

import java.util.ArrayList;

import com.cognizant.truyum.model.MenuItem;

public class CartDaoSqlImplTest {

public static void main(String[] args)
{
testAddCartItem();
testGetAllCartItems();
testRemoveCartItem();

}
public static void testAddCartItem()
{
CartDao cartDao = new CartDaoSqlImpl();
cartDao.addCartItem((long)1, (long) 1);
cartDao.addCartItem((long)1, (long) 3);
try
{
@SuppressWarnings("unchecked")
ArrayList<MenuItem> cartList = cartDao.getAllCartItems((long)1);
System.out.println("items added to cart successfuly");
System.out.println(String.format("%-25s%-25s%-25s%-25s%-25s%-20s\n","Name","Price","Active","Date Of Launch","Category","Free Delivery"));

for (MenuItem item : cartList) {

System.out.println(String.format("%-25s%-25s%-25s%-25s%-25s%-20s\n",item.getName(),item.getPrice(),item.isActive(),item.getDateOfLaunch(),item.getCategory(),item.isFreeDelivery()));

}

}
catch(CartEmptyException e)
{
e.printStackTrace();
}



}
public static void testGetAllCartItems()
{
CartDao cartDao = new CartDaoSqlImpl();
try
{
@SuppressWarnings("unchecked")
ArrayList<MenuItem> cartItems = cartDao.getAllCartItems((long)1);
System.out.println(String.format("%-25s%-25s%-25s%-25s%-25s%-25s\n","Name","Price","Active","Date Of Launch","Category","Free Delivery"));
for(MenuItem item:cartItems)
{
System.out.println(String.format("%-25s%-25s%-25s%-25s%-25s%-25s\n",item.getName(),item.getPrice(),item.isActive(),item.getDateOfLaunch(),item.getCategory(),item.isFreeDelivery()));
}
}
catch(CartEmptyException e)
{
e.printStackTrace();
}

}
public static void testRemoveCartItem()
{
CartDao cartDao = new CartDaoSqlImpl();
cartDao.removeCartItem((long)1,(long)1);
try
{
@SuppressWarnings("unchecked")
ArrayList<MenuItem> cartLefts = cartDao.getAllCartItems((long)1);
if(cartLefts.isEmpty())
{
throw new CartEmptyException("cart is empty");
}
else
{
for(MenuItem item:cartLefts)
{
System.out.println(String.format("%-25s%-25s%-25s%-25s%-25s%-20s\n",item.getName(),item.getPrice(),item.isActive(),item.getDateOfLaunch(),item.getCategory(),item.isFreeDelivery()));
}
}
}
catch(CartEmptyException e)
{
e.printStackTrace();
}
}

}