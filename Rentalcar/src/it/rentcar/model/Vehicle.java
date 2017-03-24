package it.rentcar.model;

import java.io.Serializable;

public class Vehicle  implements Serializable{

		private String sipp;
		private String name;
		private double price;
		private String supplier;
		private double rating;
		
		public Vehicle(String price, String name, double rating ,String sipp, String supplier ){
			this.price=(null!=price)? Double.parseDouble(price) : 0.0;
			this.sipp=(null!=sipp)? sipp : "";
			this.name=(null!=name)? name : "";
			this.supplier=(null!=supplier)? supplier : "";
			this.rating=(rating>0)? rating : 0.0;
		}
		
		public Vehicle(double price, String name, double rating ,String sipp, String supplier ){
			this.price=( price >0 )? price : 0.0;
			this.sipp=(null!=sipp)? sipp : "";
			this.name=(null!=name)? name : "";
			this.supplier=(null!=supplier)? supplier : "";
			this.rating=(rating>0)? rating : 0.0;
		}
		
		public String getSipp() {
			return sipp;
		}
		public String getName() {
			return name;
		}
		public double getPrice() {
			return price;
		}
		public String getSupplier() {
			return supplier;
		}
		public double getRating() {
			return rating;
		}
		public void setSipp(String sipp) {
			this.sipp = sipp;
		}
		public void setName(String name) {
			this.name = name;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		public void setSupplier(String supplier) {
			this.supplier = supplier;
		}
		public void setRating(double rating) {
			this.rating = rating;
		}
		
		@Override
		public String toString() {
		    return getSipp() + " : " + name + "\n" + price + "$" + "\n" + "\n";
		}
		
}
