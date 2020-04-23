package com.almacen.interfaces;

import com.almacen.app.models.DispatchDetail;

public interface IDispatchDetailsService {

	public void createDetail(DispatchDetail detail);
	public void updateDetail(DispatchDetail detail);
	public void deleteDetail(Integer idDetail);
}

