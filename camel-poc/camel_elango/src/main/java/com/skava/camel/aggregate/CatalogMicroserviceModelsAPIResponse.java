/*******************************************************************************
 * Copyright ©2002-2018 Skava - All rights reserved.
 * 
 * All information contained herein is, and remains the property of Skava.
 * Skava including, without limitation, all software and other elements thereof, 
 * are owned or controlled exclusively by Skava and protected by copyright, patent
 * and other laws. Use without permission is prohibited. 
 * Unauthorized copying of this file, via any medium is strictly prohibited
 *    
 * For further information contact Skava at info@skava.com.
 ******************************************************************************/
package com.skava.camel.aggregate;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.skava.camel.aggregate.transform.CatalogMicroserviceModel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
* <h1>CatalogAPIResponse</h1>
* The Class CatalogAPIResponse
* @author Skava
*
*/
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CatalogMicroserviceModelsAPIResponse implements Serializable {

  /* serialVersionUID. */
  private static final long serialVersionUID = 1L;

  /* It contains the list of catalog information. */
  private List<CatalogMicroserviceModel> models;
}
