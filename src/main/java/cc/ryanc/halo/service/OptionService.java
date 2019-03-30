package cc.ryanc.halo.service;

import cc.ryanc.halo.exception.MissingPropertyException;
import cc.ryanc.halo.model.dto.OptionOutputDTO;
import cc.ryanc.halo.model.entity.Option;
import cc.ryanc.halo.model.enums.PropertyEnum;
import cc.ryanc.halo.model.enums.ValueEnum;
import cc.ryanc.halo.model.params.OptionParam;
import cc.ryanc.halo.service.base.CrudService;
import com.qiniu.common.Zone;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;

/**
 * Option service.
 *
 * @author johnniang
 */
public interface OptionService extends CrudService<Option, Integer> {

    int DEFAULT_POST_PAGE_SIZE = 10;

    int DEFAULT_COMMENT_PAGE_SIZE = 10;

    int DEFAULT_RSS_PAGE_SIZE = 20;

    /**
     * Save one option
     *
     * @param key    key must not be blank
     * @param value  value
     * @param source source
     */
    void save(@NonNull String key, String value, String source);

    /**
     * Save multiple options
     *
     * @param options options
     * @param source  source
     */
    void save(@NonNull Map<String, String> options, String source);

    /**
     * SAve multiple options
     *
     * @param optionParams option params
     * @param source       source
     */
    void save(List<OptionParam> optionParams, String source);

    /**
     * Saves blog properties.
     *
     * @param properties blog properties
     * @param source     source
     */
    void saveProperties(@NonNull Map<? extends PropertyEnum, String> properties, String source);

    /**
     * Get all options
     *
     * @return Map
     */
    Map<String, String> listOptions();

    /**
     * Lists all option dtos.
     *
     * @return a list of option dto
     */
    List<OptionOutputDTO> listDtos();

    /**
     * Get option by key
     *
     * @param key option key must not be blank
     * @return option value or null
     */
    @Nullable
    String getByKeyOfNullable(@NonNull String key);

    /**
     * Gets option value of non null.
     *
     * @param key option key must not be null
     * @return option value of non null
     */
    @NonNull
    String getByKeyOfNonNull(@NonNull String key);

    /**
     * Get option by key
     *
     * @param key option key must not be blank
     * @return an optional option value
     */
    @NonNull
    Optional<String> getByKey(@NonNull String key);

    /**
     * Gets option value by blog property.
     *
     * @param property blog property must not be null
     * @return an option value
     */
    @Nullable
    String getByPropertyOfNullable(@NonNull PropertyEnum property);

    /**
     * Gets option value by blog property.
     *
     * @param property blog property
     * @return an optiona value
     * @throws MissingPropertyException throws when property value dismisses
     */
    @NonNull
    String getByPropertyOfNonNull(@NonNull PropertyEnum property);

    /**
     * Gets option value by blog property.
     *
     * @param property blog property must not be null
     * @return an optional option value
     */
    @NonNull
    Optional<String> getByProperty(@NonNull PropertyEnum property);

    /**
     * Gets property value by blog property.
     *
     * @param property     blog property must not be null
     * @param propertyType property type must not be null
     * @param defaultValue default value
     * @param <T>          property type
     * @return property value
     */
    <T> T getByPropertyOrDefault(@NonNull PropertyEnum property, @NonNull Class<T> propertyType, T defaultValue);

    /**
     * Gets property value by blog property.
     *
     * @param property     blog property must not be null
     * @param propertyType property type must not be null
     * @param <T>          property type
     * @return property value
     */
    <T> Optional<T> getByProperty(@NonNull PropertyEnum property, @NonNull Class<T> propertyType);

    /**
     * Gets value by key.
     *
     * @param key          key must not be null
     * @param valueType    value type must not be null
     * @param defaultValue default value
     * @param <T>          property type
     * @return value
     */
    <T> T getByKeyOrDefault(@NonNull String key, @NonNull Class<T> valueType, T defaultValue);

    /**
     * Gets value by key.
     *
     * @param key       key must not be null
     * @param valueType value type must not be null
     * @param <T>       value type
     * @return value
     */
    @NonNull
    <T> Optional<T> getByKey(@NonNull String key, @NonNull Class<T> valueType);

    /**
     * Gets enum value by property.
     *
     * @param property  property must not be blank
     * @param valueType enum value type must not be null
     * @param <T>       enum value type
     * @return an optional enum value
     */
    @NonNull
    <T extends Enum<T>> Optional<T> getEnumByProperty(@NonNull PropertyEnum property, @NonNull Class<T> valueType);

    /**
     * Gets enum value by property.
     *
     * @param property     property must not be blank
     * @param valueType    enum value type must not be null
     * @param defaultValue default value
     * @param <T>          enum value type
     * @return enum value
     */
    @Nullable
    <T extends Enum<T>> T getEnumByPropertyOrDefault(@NonNull PropertyEnum property, @NonNull Class<T> valueType, @Nullable T defaultValue);

    /**
     * Gets value enum by property.
     *
     * @param property  property must not be blank
     * @param valueType enum value type must not be null
     * @param enumType  enum type must not be null
     * @param <V>       enum value type
     * @param <E>       value enum type
     * @return an optional value enum value
     */
    @NonNull
    <V, E extends ValueEnum<V>> Optional<E> getValueEnumByProperty(@NonNull PropertyEnum property, @NonNull Class<V> valueType, @NonNull Class<E> enumType);

    /**
     * Gets value enum by property.
     *
     * @param property     property must not be blank
     * @param valueType    enum value type must not be null
     * @param enumType     enum type must not be null
     * @param defaultValue default value enum value
     * @param <V>          enum value type
     * @param <E>          value enum type
     * @return value enum value or null if the default value is null
     */
    @Nullable
    <V, E extends ValueEnum<V>> E getValueEnumByPropertyOrDefault(@NonNull PropertyEnum property, @NonNull Class<V> valueType, @NonNull Class<E> enumType, @Nullable E defaultValue);


    /**
     * Gets post page size.
     *
     * @return page size
     */
    int getPostPageSize();

    /**
     * Gets comment page size.
     *
     * @return page size
     */
    int getCommentPageSize();

    /**
     * Gets rss page size.
     *
     * @return page size
     */
    int getRssPageSize();

    /**
     * Get qi niu yun zone.
     *
     * @return qiniu zone
     */
    @NonNull
    Zone getQnYunZone();

    /**
     * Gets locale.
     *
     * @return locale user set or default locale
     */
    @NonNull
    Locale getLocale();

}