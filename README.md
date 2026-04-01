# Strukdat-Modul-3-Class-Diagram
<br/>

## Deskripsi

Sebuah usaha rental PlayStation selama ini masih melakukan pencatatan data penyewaan secara manual menggunakan buku. Metode tersebut menimbulkan beberapa permasalahan, seperti:

1.Data pelanggan sulit diperbarui

2.Jadwal penggunaan PlayStation sering tidak terorganisir

3.Perhitungan biaya sewa kurang rapi

4.Sulit melakukan pencarian atau penghapusan data tertentu

Berdasarkan permasalahan tersebut, dibuat sebuah program Sistem Manajemen Rental PlayStation berbasis Java dengan menggunakan paradigma Object-Oriented Programming (OOP).

Program ini dirancang untuk membantu pengelolaan:

1.Data pelanggan

2.Jadwal penyewaan (sesi bermain)

3.Pembayaran atau biaya sewa

## Class Diagram

## Output

## Prinsip OOP

**Encapsulation**

Encapsulation diterapkan dengan cara menyembunyikan atribut menggunakan `private` pada setiap class.

Contoh pada class Karyawan:

```bash
private int id;
private String nama;
```

Atribut tersebut tidak dapat diakses langsung, melainkan melalui method getter dan setter

**Inheritance**

Class:

```bash

Pelanggan

SesiMain

Pembayaran
```
mewarisi class:

Rental

**Polymorphism**

Method info() dioverride di setiap class:

@Override
public void info()

**Abstraction**

Class Rental menjadi gambaran umum sistem.
<br/>

keunikan

1. Simulasi Dunia Nyata (Rental PS)

2. Relasi Menggunakan ID

3. Validasi ID
