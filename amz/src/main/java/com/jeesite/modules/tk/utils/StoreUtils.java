package com.jeesite.modules.tk.utils;

import java.util.ArrayList;
import java.util.List;

import com.jeesite.modules.bz.entity.BzStore;
import com.jeesite.modules.bz.entity.BzStoreAttr;
import com.xunlikun.entity.AmzStore;
import com.xunlikun.entity.AmzStoreAttr;

public class StoreUtils {

	public static AmzStore genAmzStore(BzStore bzStore) {
		if(null == bzStore) {
			return null;
		}
		AmzStore store = new AmzStore();
		store.setCode(bzStore.getCode());
		store.setStoreName(bzStore.getStoreName());
		store.setStoreType(bzStore.getStoreType());
		store.setOwner(bzStore.getOwner());
		store.setOwnerName(bzStore.getOwnerName());
		List<AmzStoreAttr> amzAttrs = new ArrayList<AmzStoreAttr>();
		for(BzStoreAttr bzAttr : bzStore.getBzStoreAttrList()) {
			AmzStoreAttr attr = new AmzStoreAttr();
			attr.setCode(bzAttr.getCode());
			attr.setAttrname(bzAttr.getAttrname());
			attr.setAttrvalue(bzAttr.getAttrvalue());
			attr.setStoreCode(store);
			attr.setTag(bzAttr.getTag());
			amzAttrs.add(attr);
		}
		store.setBzStoreAttrList(amzAttrs);
		return store;
	}
}
