package com.acme.offirent;


import com.acme.offirent.domain.model.District;
import com.acme.offirent.domain.model.Office;
import com.acme.offirent.domain.repository.DistrictRepository;
import com.acme.offirent.domain.repository.OfficeRepository;
import com.acme.offirent.domain.service.OfficeService;
import com.acme.offirent.exception.ResourceNotFoundException;
import com.acme.offirent.service.OfficeServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.*;
import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class OfficeServiceImplIntegrationTest {

    @MockBean
    private OfficeRepository officeRepository;

    @MockBean
    private DistrictRepository districtRepository;

    @Autowired
    private OfficeService officeService;


    @TestConfiguration
    static class OfficeServiceImplTestConfiguration{

        @Bean
        public OfficeService officeService(){
            return new OfficeServiceImpl();
        }
    }

    @Test
    @DisplayName("When GetOfficeById With Valid Id Then Returns Office")
    public void whenGetOfficeByIdWithValidIdThenReturnsOffice(){

        //Arrange
        Long id = 1L;
        Office office= new Office();
        office.setId(id);

        when(officeRepository.findById(office.getId()))
                .thenReturn(Optional.of(office));


        //Act
        Office searchedOffice = officeService.getOfficeById(id);

        //Assert
        assertThat(searchedOffice.getId()).isEqualTo(id);
    }

    @Test
    @DisplayName("When GetOfficeById With Invalid Id Then Returns Resource Not Found Exception")
    public void whenGetOfficeByIdWithInvalidIdThenReturnsResourceNotFoundException(){

        //Arrange
        Long invalidId = 1L;
        String template ="Resource %s not found for %s with value %s"; //metodo comun
        String expectedMessage = String.format(template,"Office","Id",invalidId);   //metodo comun

        when(officeRepository.findById(invalidId))
                .thenReturn(Optional.empty());

        //Act
        Throwable exception= catchThrowable(()->{
            Office searchedOffice = officeService.getOfficeById(invalidId);
        });

        //Assert
        assertThat(exception)
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessage(expectedMessage);
    }



    @Test
    @DisplayName("When GetAllOfficesByDistrictId With Valid DistrictId Then Returns Offices")
    public void whenGetAllOfficesByDistrictIdWithValidDistrictIdThenReturnsOffices(){

        //Arrange

        Pageable pageable= new Pageable() {
            @Override
            public int getPageNumber() {
                return 0;
            }

            @Override
            public int getPageSize() {
                return 0;
            }

            @Override
            public long getOffset() {
                return 0;
            }

            @Override
            public Sort getSort() {
                return null;
            }

            @Override
            public Pageable next() {
                return null;
            }

            @Override
            public Pageable previousOrFirst() {
                return null;
            }

            @Override
            public Pageable first() {
                return null;
            }

            @Override
            public boolean hasPrevious() {
                return false;
            }
        };
        List<Office> officeList = new List<Office>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<Office> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(Office office) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends Office> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, Collection<? extends Office> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public Office get(int index) {
                return null;
            }

            @Override
            public Office set(int index, Office element) {
                return null;
            }

            @Override
            public void add(int index, Office element) {

            }

            @Override
            public Office remove(int index) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator<Office> listIterator() {
                return null;
            }

            @Override
            public ListIterator<Office> listIterator(int index) {
                return null;
            }

            @Override
            public List<Office> subList(int fromIndex, int toIndex) {
                return null;
            }
        };
        int officeListCount= officeList.size();
        Page<Office> officePage = new PageImpl<>( officeList,pageable, officeListCount);

        Long id=2L;
        District district= new District();
        district.setId(id);
        district.setOffices(officeList);

        when(districtRepository.findById(district.getId()))
                .thenReturn(Optional.of(district));

        //Act
        Page<Office> offices= officeService.getAllOfficesByDistrictId(id, pageable);

        //Assert
        assertThat(offices).isEqualTo(officePage);
    }

    @Test
    @DisplayName("When GetAllOfficesByDistrictId With Invalid DistrictId Then Returns Resource Resource Not Found Exception")
    public void whenGetAllOfficesByDistrictIdWithInvalidDistrictIdThenReturnsResourceResourceNotFoundException(){

        //Arrange
        Long invalidId = 1L;
        Pageable pageable=new Pageable() {
            @Override
            public int getPageNumber() {
                return 0;
            }

            @Override
            public int getPageSize() {
                return 0;
            }

            @Override
            public long getOffset() {
                return 0;
            }

            @Override
            public Sort getSort() {
                return null;
            }

            @Override
            public Pageable next() {
                return null;
            }

            @Override
            public Pageable previousOrFirst() {
                return null;
            }

            @Override
            public Pageable first() {
                return null;
            }

            @Override
            public boolean hasPrevious() {
                return false;
            }
        };
        String template = "Resource %s not found for %s with value %s";
        String expectedMessage = String.format(template,"District","Id",invalidId);

        when(districtRepository.findById(invalidId))
                .thenReturn(Optional.empty());

        //Act
        Throwable exception= catchThrowable(()->{
                Page<Office> offices= officeService.getAllOfficesByDistrictId(invalidId, pageable);});

        //Assert
        assertThat(exception)
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessage(expectedMessage);
    }



    @Test
    @DisplayName("When GetAllOfficesByPriceLessThanEqual With Valid Price Then Returns Offices")
    public void whenGetAllOfficesByPriceLessThanEqualWithValidPriceThenReturnsOffices(){

        //Arrange
        Float price = 50f;
        Office office=new Office();
        office.setId(1l);
        office.setPrice(price);


        Pageable pageable=new Pageable() {
            @Override
            public int getPageNumber() {
                return 0;
            }

            @Override
            public int getPageSize() {
                return 0;
            }

            @Override
            public long getOffset() {
                return 0;
            }

            @Override
            public Sort getSort() {
                return null;
            }

            @Override
            public Pageable next() {
                return null;
            }

            @Override
            public Pageable previousOrFirst() {
                return null;
            }

            @Override
            public Pageable first() {
                return null;
            }

            @Override
            public boolean hasPrevious() {
                return false;
            }
        };
        List<Office> officeList=new List<Office>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<Office> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(Office office) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends Office> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, Collection<? extends Office> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public Office get(int index) {
                return null;
            }

            @Override
            public Office set(int index, Office element) {
                return null;
            }

            @Override
            public void add(int index, Office element) {

            }

            @Override
            public Office remove(int index) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator<Office> listIterator() {
                return null;
            }

            @Override
            public ListIterator<Office> listIterator(int index) {
                return null;
            }

            @Override
            public List<Office> subList(int fromIndex, int toIndex) {
                return null;
            }
        };
        officeList.add(office);
        int officeListCount=officeList.size();
        Page<Office> officePage= new PageImpl<>(officeList,pageable,officeListCount);


        when(officeRepository.findByPriceLessThanEqual(price, pageable))
                .thenReturn(Optional.of(officePage));

        //Act
        Page<Office> offices = officeService.getAllOfficesByPriceLessThanEqual(price, pageable);

        //Assert
        assertThat(offices).isEqualTo(officePage);
    }

    @Test
    @DisplayName("When GetAllOfficesByPriceLessThanEqual With Invalid Price Then Returns Resource Not Found Exception")
    public void whenGetAllOfficesByPriceLessThanEqualWithInvalidPriceThenReturnsResourceNotFoundException(){

        //Arrange
        Float invalidPrice = 5f;
        String template="Resource %s not found for %s with value %s";
        String expectedMessage = String.format(template,"Office","Price",invalidPrice);

        Pageable pageable=new Pageable() {
            @Override
            public int getPageNumber() {
                return 0;
            }

            @Override
            public int getPageSize() {
                return 0;
            }

            @Override
            public long getOffset() {
                return 0;
            }

            @Override
            public Sort getSort() {
                return null;
            }

            @Override
            public Pageable next() {
                return null;
            }

            @Override
            public Pageable previousOrFirst() {
                return null;
            }

            @Override
            public Pageable first() {
                return null;
            }

            @Override
            public boolean hasPrevious() {
                return false;
            }
        };

        when(officeRepository.findByPriceLessThanEqual(invalidPrice,pageable))
                .thenReturn(Optional.empty());

        //Act
        Throwable exception= catchThrowable( ()->{
                Page<Office> offices= officeService.getAllOfficesByPriceLessThanEqual(invalidPrice, pageable);} );

        //Assert
        assertThat(exception)
                .isInstanceOf(ResourceNotFoundException.class).hasMessage(expectedMessage);
    }


}
