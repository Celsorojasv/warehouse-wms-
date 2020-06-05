package com.almacen.interfaces;

import java.util.List;

import com.almacen.app.models.DispatchDetail;

public interface IDispatchDetailsService {

	public List<DispatchDetail> list();
	public void createDetail(DispatchDetail detail);
	public void updateDetail(DispatchDetail detail);
	public void deleteDetail(Integer idDetail);
}

