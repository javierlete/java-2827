package com.ipartek.formacion.multimodulo.logicanegocio;

import com.ipartek.formacion.multimodulo.entidades.Producto;

public interface AdminNegocio extends AnonimoNegocio {

	void anyadirProducto(Producto producto);

	void modificarProducto(Producto producto);

	void borrarProducto(Long id);

}
