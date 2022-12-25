package dto.cart;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CartDTO {
	private int cart_detail_id;
	private int cart_detail_item_count;
	private int product_id;
	private String user_id;
	private long user_cart_price;

	// DB에서 받아올 정보
	private String product_name;
	private int product_price;
	private String product_filename;
	private String product_savedname;
	private String product_contenttype;

}
