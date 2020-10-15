/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oozeander.spring;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 *
 * @author Oozeander (aka Billel KETROUCI°
 */
@Configuration
@Import({JdbcConfig.class})
public class JavaConfig {
}
