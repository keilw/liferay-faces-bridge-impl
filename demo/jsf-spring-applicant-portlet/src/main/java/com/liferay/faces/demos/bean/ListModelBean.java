/**
 * Copyright (c) 2000-2018 Liferay, Inc. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.liferay.faces.demos.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.liferay.faces.demos.dto.City;
import com.liferay.faces.demos.dto.Province;


/**
 * @author  Neil Griffin
 */
@Named
@Scope("singleton")
public class ListModelBean implements Serializable {

	// serialVersionUID
	private static final long serialVersionUID = 3980998854968479941L;

	// Private Data Members
	private List<City> cities;
	private List<Province> provinces;

	public List<City> getCities() {

		if (cities == null) {
			long cityId = 1;
			cities = new ArrayList<City>();

			City city = new City(cityId++, getProvinceId("DE"), "Wilmington", "19806");
			cities.add(city);
			city = new City(cityId++, getProvinceId("GA"), "Atlanta", "30329");
			cities.add(city);
			city = new City(cityId++, getProvinceId("FL"), "Orlando", "32801");
			cities.add(city);
			city = new City(cityId++, getProvinceId("MD"), "Baltimore", "21224");
			cities.add(city);
			city = new City(cityId++, getProvinceId("NC"), "Charlotte", "28202");
			cities.add(city);
			city = new City(cityId++, getProvinceId("NJ"), "Hoboken", "07030");
			cities.add(city);
			city = new City(cityId++, getProvinceId("NY"), "Albany", "12205");
			cities.add(city);
			city = new City(cityId++, getProvinceId("SC"), "Columbia", "29201");
			cities.add(city);
			city = new City(cityId++, getProvinceId("VA"), "Roanoke", "24013");
			cities.add(city);
		}

		return cities;
	}

	public City getCityByPostalCode(String postalCode) {
		List<City> cities = getCities();

		for (City city : cities) {

			if (city.getPostalCode().equals(postalCode)) {
				return city;
			}
		}

		return null;
	}

	public long getProvinceId(String provinceName) {
		long provinceId = 0;
		List<Province> provinces = getProvinces();

		for (Province province : provinces) {

			if (province.getProvinceName().equals(provinceName)) {
				provinceId = province.getProvinceId();

				break;
			}
		}

		return provinceId;
	}

	public List<Province> getProvinces() {

		if (provinces == null) {
			long provinceId = 1;
			provinces = new ArrayList<Province>();

			Province province = new Province(provinceId++, "DE");
			provinces.add(province);
			province = new Province(provinceId++, "GA");
			provinces.add(province);
			province = new Province(provinceId++, "FL");
			provinces.add(province);
			province = new Province(provinceId++, "MD");
			provinces.add(province);
			province = new Province(provinceId++, "NC");
			provinces.add(province);
			province = new Province(provinceId++, "NJ");
			provinces.add(province);
			province = new Province(provinceId++, "NY");
			provinces.add(province);
			province = new Province(provinceId++, "SC");
			provinces.add(province);
			province = new Province(provinceId++, "VA");
			provinces.add(province);
		}

		return this.provinces;
	}
}
