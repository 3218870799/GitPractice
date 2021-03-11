package com.xqc.thread.Sekill;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SeckillWithReadWriterLock {
    @Autowired
    private SeckillItemMapper seckillItemMapper;
    @Autowired
    private SeckillRecordMapper seckillRecordMapper;

    public CommonResult seckill(String seckillItemId, String userPhone) {

        CommonResult result = new CommonResult();
        ReadWriteLock lock = new ReentrantReadWriteLock();

        try {
            /* 1����ѯ��ɱ��Ʒʣ������*/
            //�Ӷ���
            lock.readLock().lock();
            SeckillItem seckillItem = seckillItemMapper.selectByPrimaryKey(seckillItemId);
            int itemAccount = seckillItem != null ? seckillItem.getNumber() : 0;
            if (itemAccount < 1) {
                result.setStatus(false);
                result.setMessage("��Ʒ��" + seckillItem.getName() + "���Ѿ���������~");
                return result;
            }
            lock.readLock().unlock();

            /* 2��������ɱ��Ʒʣ������*/
            lock.writeLock().lock();
            seckillItem.setNumber(seckillItem.getNumber() - 1);
            seckillItemMapper.updateByPrimaryKey(seckillItem);

            /* 3�������ɱ��¼*/
            SeckillRecord seckillRecord = new SeckillRecord();
            seckillRecord.setSeckillItemId(seckillItemId);
            seckillRecord.setState(0);
            seckillRecord.setUserPhone(userPhone);
            seckillRecord.setCreateTime(new Date());
            seckillRecordMapper.insert(seckillRecord);
            lock.writeLock().unlock();

            result.setData(seckillItem);
            result.setMessage("��ϲ��������Ʒ��" + seckillItem.getName() + "��");
        } catch (Exception e) {
            lock.readLock().unlock();
            lock.writeLock().unlock();
            e.printStackTrace();
            result.setStatus(false);
            result.setMessage("���˵�С���⣬���ǵĹ���ʨ���ڷ�������~");
            return result;
        }
        return result;
    }
}
