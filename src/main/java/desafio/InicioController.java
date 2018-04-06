package desafio;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import desafio.saraiva.SaraivaApi;


@RestController
@RequestMapping("/book")
public class InicioController {

    @Autowired
	private  BookRepository bookRepository;

    
	@RequestMapping(method = RequestMethod.DELETE, value = "/{sku}")
	@ResponseStatus(HttpStatus.NO_CONTENT) //204
    public void delete(@PathVariable Long sku) {
         System.out.println("DELETE: " + sku);   	 
     		 bookRepository.deleteById(sku);     	
    }

	@RequestMapping(method = RequestMethod.GET, value = "/{sku}")
	@ResponseStatus(HttpStatus.OK)  //200
	@ResponseBody
    Book get(@PathVariable Long sku) {

 		Book book = bookRepository.findById(sku).get();
 		return book;
    }
	

	@RequestMapping(method = RequestMethod.POST)
    public void post2(@RequestParam(value="sku", required=false ) String sku ) {
		
		if (sku != null) {
			RestTemplate restTemplate = new RestTemplate();
			SaraivaApi saraivaApi= restTemplate.getForObject("https://api.saraiva.com.br/sc/produto/pdp/"+sku+"/0/0/1/", SaraivaApi.class);
	    
			Book book = new Book();
			book.setSku(Long.valueOf(saraivaApi.getSku()));
	        book.setName(saraivaApi.getName());
	        book.setBrand(saraivaApi.getBrand());
	        book.setPrice(new BigDecimal( saraivaApi.getPrice().getBestPrice().getValue().replaceAll("\\.", "").replace(",",".")) );
	        
	        bookRepository.save(book);
		}
  }


//    @GetMapping	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
    public List<Book> list(@RequestParam(value="price", required=false ) String price, @RequestParam(value="limit", required=false) String limit) {
        List<Book> books = null ; 
        if (price != null && limit  != null) {
            Pageable limitReg = PageRequest.of(0, 20);
        	books = bookRepository.findByPriceLessThanEqual(new BigDecimal(price), limitReg);		
        } 
        if (price ==null && limit != null) {
            Pageable limitReg = PageRequest.of(0, 20);
        	books = bookRepository.findAll( limitReg);	
        }
        if (price != null && limit ==null) {
        	books =bookRepository.findAllByPriceLessThanEqual(new BigDecimal(price));
        }
 		return books;
    }


}

