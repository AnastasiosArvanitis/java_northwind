package info.anastasios.java_northwind.bo;

import java.time.LocalDate;

public class Order {

    private int orderId;
    private Customer customer;
    private Employee employee;
    private LocalDate orderDate;
    private LocalDate requiredDate;
    private LocalDate ShippedDate;
    private Shipper shipper;
    private double freight;
    private String shipName;
    private String shipAddress;
    private String shipCity;
    private String shipRegion;
    private String shipPostalCode;
    private String shipCountry;

    public Order() {}

    public Order(
                 Customer customer,
                 Employee employee,
                 LocalDate orderDate,
                 LocalDate requiredDate,
                 LocalDate shippedDate,
                 Shipper shipper,
                 double freight,
                 String shipName,
                 String shipAddress,
                 String shipCity,
                 String shipRegion,
                 String shipPostalCode,
                 String shipCountry) {
        this.customer = customer;
        this.employee = employee;
        this.orderDate = orderDate;
        this.requiredDate = requiredDate;
        ShippedDate = shippedDate;
        this.shipper = shipper;
        this.freight = freight;
        this.shipName = shipName;
        this.shipAddress = shipAddress;
        this.shipCity = shipCity;
        this.shipRegion = shipRegion;
        this.shipPostalCode = shipPostalCode;
        this.shipCountry = shipCountry;
    }

    public Order(int orderId,
                 Customer customer,
                 Employee employee,
                 LocalDate orderDate,
                 LocalDate requiredDate,
                 LocalDate shippedDate,
                 Shipper shipper,
                 double freight,
                 String shipName,
                 String shipAddress,
                 String shipCity,
                 String shipRegion,
                 String shipPostalCode,
                 String shipCountry) {
        this.orderId = orderId;
        this.customer = customer;
        this.employee = employee;
        this.orderDate = orderDate;
        this.requiredDate = requiredDate;
        ShippedDate = shippedDate;
        this.shipper = shipper;
        this.freight = freight;
        this.shipName = shipName;
        this.shipAddress = shipAddress;
        this.shipCity = shipCity;
        this.shipRegion = shipRegion;
        this.shipPostalCode = shipPostalCode;
        this.shipCountry = shipCountry;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDate getRequiredDate() {
        return requiredDate;
    }

    public void setRequiredDate(LocalDate requiredDate) {
        this.requiredDate = requiredDate;
    }

    public LocalDate getShippedDate() {
        return ShippedDate;
    }

    public void setShippedDate(LocalDate shippedDate) {
        ShippedDate = shippedDate;
    }

    public Shipper getShipper() {
        return shipper;
    }

    public void setShipper(Shipper shipper) {
        this.shipper = shipper;
    }

    public double getFreight() {
        return freight;
    }

    public void setFreight(double freight) {
        this.freight = freight;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public String getShipAddress() {
        return shipAddress;
    }

    public void setShipAddress(String shipAddress) {
        this.shipAddress = shipAddress;
    }

    public String getShipCity() {
        return shipCity;
    }

    public void setShipCity(String shipCity) {
        this.shipCity = shipCity;
    }

    public String getShipRegion() {
        return shipRegion;
    }

    public void setShipRegion(String shipRegion) {
        this.shipRegion = shipRegion;
    }

    public String getShipPostalCode() {
        return shipPostalCode;
    }

    public void setShipPostalCode(String shipPostalCode) {
        this.shipPostalCode = shipPostalCode;
    }

    public String getShipCountry() {
        return shipCountry;
    }

    public void setShipCountry(String shipCountry) {
        this.shipCountry = shipCountry;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", customer=" + customer +
                ", employee=" + employee +
                ", orderDate=" + orderDate +
                ", requiredDate=" + requiredDate +
                ", ShippedDate=" + ShippedDate +
                ", shipper=" + shipper +
                ", freight=" + freight +
                ", shipName='" + shipName + '\'' +
                ", shipAddress='" + shipAddress + '\'' +
                ", shipCity='" + shipCity + '\'' +
                ", shipRegion='" + shipRegion + '\'' +
                ", shipPostalCode='" + shipPostalCode + '\'' +
                ", shipCountry='" + shipCountry + '\'' +
                '}';
    }
}
