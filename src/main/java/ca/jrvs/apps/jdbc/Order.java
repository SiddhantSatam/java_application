package ca.jrvs.apps.jdbc;

import ca.jrvs.apps.jdbc.util.DataTransferObject;

import java.util.Date;

public class Order implements DataTransferObject {
    /**
     * SELECT  c.first_name, c.last_name, c.email, o.order_id,  o.creation_date, o.total_due,
     * o.status,  s.first_name, s.last_name, s.email,  ol.quantity,  p.code, p.name, p.size, p.variety,
     * p.pricefrom orders ojoin customer c on o.customer_id = c.customer_idjoin salesperson s
     * ono.salesperson_id=s.salesperson_idjoin order_item ol on ol.order_id=o.order_idjoin product p on ol.product_id = p.product_idwhere o.order_id = ?;
     */
    private String custFN;
    private String custLN;
    private String cust_email;
    private long orderID;
    private Date orderDate;
    private Integer orderTotalDue;
    private String orderStatus;
    private String salespersonFN;


    private String salespersonLN;
    private String salespersonEmail;
    private Integer orderQuantity;
    private String prodCode;
    private String prodName;
    private Integer prodSize;
    private String prodVar;
    private Integer prodPrice;
    private long id;

    @Override
    public String toString() {
        return "Order{" +
                "custFN='" + custFN + '\'' +
                ", custLN='" + custLN + '\'' +
                ", cust_email='" + cust_email + '\'' +
                ", orderID=" + orderID +
                ", orderDate=" + orderDate +
                ", orderTotalDue=" + orderTotalDue +
                ", orderStatus='" + orderStatus + '\'' +
                ", salespersonFN='" + salespersonFN + '\'' +
                ", salespersonLN='" + salespersonLN + '\'' +
                ", salespersonEmail='" + salespersonEmail + '\'' +
                ", orderQuantity=" + orderQuantity +
                ", prodCode='" + prodCode + '\'' +
                ", prodName='" + prodName + '\'' +
                ", prodSize=" + prodSize +
                ", prodVar='" + prodVar + '\'' +
                ", prodPrice=" + prodPrice +
                ", id=" + id +
                '}';
    }

    public String getCustFN() {
        return custFN;
    }

    public void setCustFN(String custFN) {
        this.custFN = custFN;
    }

    public String getCustLN() {
        return custLN;
    }

    public void setCustLN(String custLN) {
        this.custLN = custLN;
    }

    public String getCust_email() {
        return cust_email;
    }

    public void setCust_email(String cust_email) {
        this.cust_email = cust_email;
    }

    public long getOrderID() {
        return orderID;
    }

    public void setOrderID(long orderID) {
        this.orderID = orderID;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Integer getOrderTotalDue() {
        return orderTotalDue;
    }

    public void setOrderTotalDue(Integer orderTotalDue) {
        this.orderTotalDue = orderTotalDue;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getSalespersonFN() {
        return salespersonFN;
    }

    public void setSalespersonFN(String salespersonFN) {
        this.salespersonFN = salespersonFN;
    }

    public String getSalespersonLN() {
        return salespersonLN;
    }

    public void setSalespersonLN(String salespersonLN) {
        this.salespersonLN = salespersonLN;
    }

    public String getSalespersonEmail() {
        return salespersonEmail;
    }

    public void setSalespersonEmail(String salespersonEmail) {
        this.salespersonEmail = salespersonEmail;
    }

    public Integer getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(Integer orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public String getProdCode() {
        return prodCode;
    }

    public void setProdCode(String prodCode) {
        this.prodCode = prodCode;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public Integer getProdSize() {
        return prodSize;
    }

    public void setProdSize(Integer prodSize) {
        this.prodSize = prodSize;
    }

    public String getProdVar() {
        return prodVar;
    }

    public void setProdVar(String prodVar) {
        this.prodVar = prodVar;
    }

    public Integer getProdPrice() {
        return prodPrice;
    }

    public void setProdPrice(Integer prodPrice) {
        this.prodPrice = prodPrice;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
