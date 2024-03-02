>**Hi all !**
>
>This is a small educational project to practice the knowledge that I received.
>The project is an OnlineShop.

The main classes are:

|               	|                 	|                            	|               	|                                             	|
|:-----------------------:	|:---------------:	|:--------------------------:	|:-------------:	|:-------------------------------------------:	|
|        **JAVA **        	|                 	|           **DB**           	|               	| Description                                 	|
|   **_class Product_**   	|                 	|    **_table products_**    	|               	|                                             	|
| _Java name_             	| _Java type_     	| _DB name_                  	| _DB type_     	|                                             	|
| id                      	| UUID            	| id                         	| binary16      	| _uniq Product ID_                           	|
| name                    	| String          	| name                       	| varchar(128)  	| _Product name_                              	|
| description             	| String          	| description                	| text          	| _Product description_                       	|
| quantity                	| int             	| quantity                   	| integer       	| _available quantity_                        	|
| price                   	| double          	| price                      	| float         	| _Product price_                             	|
| isActive                	| bool            	| ia_active                  	| bool          	|                                             	|
| category                	| Category        	| category_id                	| binary16      	| _Product category_                          	|
| supplier                	| Supplier        	| supplier_id                	| binary16      	| _Product supplier_                          	|
|                         	|                 	|                            	|               	|                                             	|
|    **_class Client_**   	|                 	|     **_table clients_**    	|               	|                                             	|
| _Java name_             	| _Java type_     	| _DB name_                  	| _DB type_     	|                                             	|
| id                      	| UUID            	| id                         	| binary16      	| _uniq Client ID_                            	|
| firstName               	| String          	| first_name                 	| varchar(128)  	| _Сlient's  name_                            	|
| secondName              	| String          	| second_name                	| varchar(128)  	| _Сlient's last name_                        	|
| address                 	| String          	| address                    	| varchar(128)  	| _Сlient's street address and hous number_   	|
| city                    	| enum            	| city                       	| varchar(128)  	| _Сlient's city_                             	|
| postCode                	| enum            	| postcode                   	| varchar(128)  	| _Сlient's  address postcode_                	|
| country                 	| enum            	| country                    	| varchar(128)  	| _Сlient's  country_                         	|
| phone                   	| String          	| phone                      	| varchar(128)  	| _Сlient's  phone number_                    	|
| DateOfBirth             	| Date            	| date_of_birth              	| timestamp     	| _Сlient's date of Birth_                    	|
| cardNumber              	| String          	| card_number                	| varchar(128)  	| _Сlient's card number_                      	|
|                         	|                 	|                            	|               	|                                             	|
|    **_class Order_**    	|                 	|     **_table orders_**     	|               	|                                             	|
| **_Java name_**         	| **_Java type_** 	| **_DB name_**              	| **_DB type_** 	|                                             	|
| id                      	| UUID            	| id                         	| binary16      	| _uniq Order ID_                             	|
| createdAt               	| Timestamp       	| created_at                 	| timestamp     	| _order date_                                	|
| usedPromoCode           	| PromoCode       	| used_promo_code            	| binary16      	| _promo code used_                           	|
| status                  	| enum            	| status                     	| varchar(128)  	| _order status_                              	|
| client                  	| Client          	| client_id                  	| binary16      	| _customer who placed an order_              	|
| shipper                 	| Shipper         	| shipper_id                 	| binary16      	| _who delivers the order_                    	|
|                         	|                 	|                            	|               	|                                             	|
| **_class OrderDetail_** 	|                 	| **_table orders_details_** 	|               	|                                             	|
| _Java name_             	| _Java type_     	| _DB name_                  	| _DB type_     	|                                             	|
| id                      	| UUID            	| id                         	| binary16      	| _uniq Order ID_                             	|
| quantity                	| int             	| quantity                   	| integer       	| _quantity of product in order_              	|
| order                   	| Order           	| order_id                   	| binary16      	| _Order number_                              	|
| products                	| List<Product>   	| product_id                 	| binary16      	| _Product name_                              	|
|                         	|                 	|                            	|               	|                                             	|
|   **_class Category_**  	|                 	|   **_table categories_**   	|               	|                                             	|
| _Java name_             	| _Java type_     	| _DB name_                  	| _DB type_     	|                                             	|
| id                      	| UUID            	| id                         	| binary16      	| _uniq Order ID_                             	|
| name                    	| String          	| name                       	| varchar(128)  	| _Сategory name_                             	|
| description             	| String          	| description                	| text          	| _Сategory description_                      	|
| parentCategoryId        	| UUID            	| parent_category_id         	| binary16      	| _Parent category ID_                        	|
|                         	|                 	|                            	|               	|                                             	|
|    **_class Review_**   	|                 	|     **_table reviews_**    	|               	|                                             	|
| _Java name_             	| _Java type_     	| _DB name_                  	| _DB type_     	|                                             	|
| id                      	| UUID            	| id                         	| binary16      	| _uniq Review ID_                            	|
| content                 	| String          	| content                    	| text          	| _Review content_                            	|
| date                    	| zonedDateTime   	| created_at                 	| timestamp     	| _date of Review_                            	|
| rate                    	| enum            	| rate                       	| varchar(128)  	| _Reviews rate_                              	|
| client                  	| Client          	| client_id                  	| binary16      	| _name of the Сlient who posted the Кeview_  	|
| product                 	| Product         	| product_id                 	| binary16      	| _Reviews Product_                           	|
|                         	|                 	|                            	|               	|                                             	|
|   **_class Supplier_**  	|                 	|    **_table suppliers_**   	|               	|                                             	|
| _Java name_             	| _Java type_     	| _DB name_                  	| _DB type_     	|                                             	|
| id                      	| UUID            	| id                         	| binary16      	| _uniq Supplier ID_                          	|
| name                    	| String          	| name                       	| varchar(128)  	| _Supplier name_                             	|
| address                 	| String          	| address                    	| varchar(128)  	| _Supplier address_                          	|
| city                    	| enum            	| city                       	| varchar(128)  	| _Supplier city_                             	|
| postCode                	| enum            	| postcode                   	| varchar(128)  	| _Supplier address postcode_                 	|
| country                 	| enum            	| country                    	| varchar(128)  	| _Supplier country_                          	|
| phone                   	| String          	| phone                      	| varchar(128)  	| _Supplier phone number_                     	|
|                         	|                 	|                            	|               	|                                             	|
|   **_class Shipper_**   	|                 	|    **_table shippers_**    	|               	|                                             	|
| _Java name_             	| _Java type_     	| _DB name_                  	| _DB type_     	|                                             	|
| id                      	| UUID            	| id                         	| binary16      	| _uniq Shipper ID_                           	|
| name                    	| String          	| name                       	| varchar(128)  	| _Shipper name_                              	|
| phone                   	| String          	| phone                      	| varchar(128)  	| _Shipper phone number_                      	|
|                         	|                 	|                            	|               	|                                             	|
|  **_class PromoCode_**  	|                 	|   **_table promo_codes_**  	|               	|                                             	|
| _Java name_             	| _Java type_     	| _DB name_                  	| _DB type_     	|                                             	|
| id                      	| UUID            	| id                         	| binary16      	| _uniq Shipper ID_                           	|
| discount                	| double          	| discount                   	| float         	| _amount of discount_                        	|
| startDate               	| zonedDateTime   	| start_date                 	| timestamp     	| _PromoCode start date_                      	|
| expDate                 	| zonedDateTime   	| exp_date                   	| timestamp     	| _PromoCode expiration date_                 	|
| maxNumberOfUses         	| int             	| max_number_of_uses         	| integer       	| _maximum allowed quantity of PromoCode use_ 	|
| used                    	| int             	| used                       	| integer       	| _number of PromoCode uses_                  	|