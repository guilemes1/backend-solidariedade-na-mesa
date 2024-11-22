-- tb_basket

INSERT INTO tb_basket (basket_id, image, name, price)
    VALUES
        (1, 'https://images.tcdn.com.br/img/img_prod/1076624/cesta_basica_miami_12_itens_303_1_b57cec8c9ba6335729cc07d1fc22bcf7.jpg', 'Inicial', 45.00),
        (2, 'https://images.tcdn.com.br/img/img_prod/1076624/cesta_basica_humax_brasil_2_17_itens_c_kit_limpeza_e_higiene_265_1_dd88857d9c55b2c361adac8d74913a5d.jpg', 'Intermediária', 120.00),
        (3, 'https://images.tcdn.com.br/img/img_prod/1076624/cesta_basica_humax_orquidea_34_itens_381_1_a3365cc6a7a62799212911bfb6d41b58.jpg', 'Completa', 200.00)
    ON DUPLICATE KEY UPDATE basket_id = VALUES(basket_id);