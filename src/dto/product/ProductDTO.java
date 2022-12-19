package dto.product;

import lombok.Data;

@Data
public class ProductDTO {
   private int product_id;
   private String product_name;
   private int product_price;
   private int product_reserve;
   private String product_company;
   private int subcategory_id;
   private int category_id;
   private double product_totalpoint;
   private String product_content;
   
   private String category_name;
   private String subcategory_name;
   
   private String product_filename;
   private String product_savedname;
   private String product_contenttype;
   
   private int users_id;
   
   private int review_board_reviewpoint;
}
