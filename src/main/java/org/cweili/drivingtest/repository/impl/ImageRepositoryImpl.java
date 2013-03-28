/**
 * 
 */
package org.cweili.drivingtest.repository.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.cweili.drivingtest.domain.Image;
import org.cweili.drivingtest.repository.ImageRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSInputFile;

/**
 * 
 * @author Cweili
 * @version 2013-3-26 下午7:31:08
 * 
 */
@Repository("imageRepository")
public class ImageRepositoryImpl implements ImageRespository, CrudRepository<Image, String> {

	@Autowired
	MongoTemplate db;

	private static GridFS gfs;
	private static final String COLLECTION = "image";

	/*
	 * （non-Javadoc）
	 * 
	 * @see
	 * org.springframework.data.repository.CrudRepository#save(java.lang.Object)
	 */
	@Override
	public <S extends Image> S save(S image) {
		setGfs();
		GridFSInputFile file;
		file = gfs.createFile(image.getData());
		file.setFilename(image.getName());
		file.setContentType("image/jpeg");
		file.save();
		return image;
	}

	/*
	 * （non-Javadoc）
	 * 
	 * @see org.springframework.data.repository.CrudRepository#count()
	 */
	@Override
	public long count() {
		// TODO 自动生成的方法存根
		return 0;
	}

	/*
	 * （non-Javadoc）
	 * 
	 * @see org.springframework.data.repository.CrudRepository#delete(java.io.
	 * Serializable)
	 */
	@Override
	public void delete(String arg0) {
		// TODO 自动生成的方法存根

	}

	/*
	 * （non-Javadoc）
	 * 
	 * @see
	 * org.springframework.data.repository.CrudRepository#delete(java.lang.Object
	 * )
	 */
	@Override
	public void delete(Image arg0) {
		// TODO 自动生成的方法存根

	}

	/*
	 * （non-Javadoc）
	 * 
	 * @see
	 * org.springframework.data.repository.CrudRepository#delete(java.lang.Iterable
	 * )
	 */
	@Override
	public void delete(Iterable<? extends Image> arg0) {
		// TODO 自动生成的方法存根

	}

	/*
	 * （non-Javadoc）
	 * 
	 * @see org.springframework.data.repository.CrudRepository#deleteAll()
	 */
	@Override
	public void deleteAll() {
		// TODO 自动生成的方法存根

	}

	/*
	 * （non-Javadoc）
	 * 
	 * @see org.springframework.data.repository.CrudRepository#exists(java.io.
	 * Serializable)
	 */
	@Override
	public boolean exists(String arg0) {
		// TODO 自动生成的方法存根
		return false;
	}

	/*
	 * （non-Javadoc）
	 * 
	 * @see org.springframework.data.repository.CrudRepository#findAll()
	 */
	@Override
	public Iterable<Image> findAll() {
		// TODO 自动生成的方法存根
		return null;
	}

	/*
	 * （non-Javadoc）
	 * 
	 * @see
	 * org.springframework.data.repository.CrudRepository#findAll(java.lang.
	 * Iterable)
	 */
	@Override
	public Iterable<Image> findAll(Iterable<String> arg0) {
		// TODO 自动生成的方法存根
		return null;
	}

	/*
	 * （non-Javadoc）
	 * 
	 * @see
	 * org.cweili.drivingtest.repository.ImageRespository#findOne(java.lang.
	 * String)
	 */
	@Override
	public Image findOne(String name) {
		setGfs();
		GridFSDBFile file = gfs.findOne(name);
		if (null == file) {
			return null;
		}
		Image image = new Image();
		image.setName(name);
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		try {
			file.writeTo(os);
			image.setData(os.toByteArray());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return image;
	}

	/*
	 * （non-Javadoc）
	 * 
	 * @see
	 * org.springframework.data.repository.CrudRepository#save(java.lang.Iterable
	 * )
	 */
	@Override
	public <S extends Image> Iterable<S> save(Iterable<S> arg0) {
		// TODO 自动生成的方法存根
		return null;
	}

	private void setGfs() {
		if (null == gfs) {
			gfs = new GridFS(db.getDb(), COLLECTION);
		}
	}
}
